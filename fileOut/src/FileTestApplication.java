import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by shenxuan on 2020/3/26 17:06
 */
public class FileTestApplication {

	public static void main(String[] args) throws IOException {

		build();

		List<String> strings = FileUtils.readLines(new File("D://22.txt"));

		List<List<String>> lists = new ArrayList<>();

		int i = 1;
		List<String> sub = new ArrayList<>();
		for (String string : strings) {
			String start = String.valueOf(i);
			if (string.startsWith(start)) {
				sub.add(string);
			}
			if (blank(string)) {
				i++;
				lists.add(sub);
				sub = new ArrayList<>();
			}

		}

		List<String> out = new ArrayList<>();

		for (List<String> l : lists) {
			//遍历每组
			int type = 0;
			for (String s : l) {
				//判断该组是Old还是No
				if (s.contains("Old ")) {
					type = 1;
				}
				if (s.contains("No ")) {
					type = 2;
				}
			}

			if (type == 1) {
				for (String s : l) {
					if (s.contains("Description")) {
						String des = s.split(":")[1];
						out.add("Old:" + des);
					}
				}
			}

			if (type == 2) {

				for (String s : l) {
					if (s.contains("Description")) {
						String des = s.split(":")[1];
						out.add("No:" + des);
					}
				}

			}

		}

		List<String> collect = out.stream().sorted().collect(Collectors.toList());

		List<String> out11 = new ArrayList<>();

		Boolean NoFlag = true;
		Boolean OldFlag = true;
		for (String s : collect) {

			if (s.contains("No")) {
				if (NoFlag) {
					out11.add(s);
					NoFlag = false;
				} else {
					String replace = s.replace("No:", "   ");
					out11.add(replace);
				}
			}

			if (s.contains("Old")) {
				if (OldFlag) {
					out11.add(s);
					OldFlag = false;
				} else {
					String replace = s.replace("Old:", "    ");
					out11.add(replace);
				}
			}

		}

		FileUtils.writeLines(new File("D://result.txt"), out11);
	}

	private static void build() throws IOException {
		List<String> strings = FileUtils.readLines(new File("D://123.txt"));

		int i = 0;

		List<String> out = new ArrayList<>();

		for (String string : strings) {
			StringBuilder sb = new StringBuilder(string);
			if (blank(string)) {
				out.add(string);
				continue;
			}
			if (!isStartWithNumber(string)) {
				StringBuilder insert = sb.insert(0, i);
				out.add(insert.toString());
			} else {
				i++;
				out.add(string);
			}

		}

		FileUtils.writeLines(new File("D://22.txt"), out);

	}


	private static boolean isStartWithNumber(String str) {
		if (blank(str)) {
			return false;
		}
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str.charAt(0) + "");
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	public static Boolean blank(String obj) {
		return StringUtils.isBlank(obj);
	}
}
