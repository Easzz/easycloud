package com.findshen.dbFiledExport.modules.common.api;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class BaseController {

    public Logger logger = LoggerFactory.getLogger(getClass());

}
