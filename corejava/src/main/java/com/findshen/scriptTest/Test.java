package com.findshen.scriptTest;

import javax.script.*;

/**
 * Created by shenxuan on 2022/1/13 8:53
 */
public class Test {
	public static void main(String[] args) {

//		String script="if getRun=0 return 111;";
//		String script="print('Hello World!');";
		String script="function getResult(){\n" +
//				"var MyJavaClass = com.findshen.scriptTest.DataSource;" +
				"var MyJavaClass = org.springframework.web.client.RestTemplate;" +
				"var result = new MyJavaClass().opsForHash().get('1476100436527157249_XGS101_RunTime');\n" +
				"return result" +
				"}";

//
//		String url = "http://jsonplaceholder.typicode.com/posts/1";
//		String str = restTemplate.getForObject(url, String.class);
//		System.out.println(str);

		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		SimpleBindings simpleBindings=new SimpleBindings();
		simpleBindings.put("name",0);
		try {

			Object eval = engine.eval(script);
			Invocable invocable = (Invocable) engine;

			Object result = invocable.invokeFunction("getResult");

			System.out.println(result);

		} catch (ScriptException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}


//		ScriptEngine engine1 = new ScriptEngineManager().getEngineByName("nashorn");
//		CompiledScript compiledScript = ((Compilable) engine1).complie("print('Hello World!');");
//		engine.eval();


	}
}
