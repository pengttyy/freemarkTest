package com.pengttyy.freeMarker.freeMarker_test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class TemplateTest {
    private Configuration cfg;
    private Template tmp;
    private Map root;
    private List<String> flagList;
	
	@Before
	public void setUp() throws Exception {
		cfg = SingleConfiguration.getInstance();
		root = new HashMap();
		flagList = new ArrayList<String>();
		tmp = cfg.getTemplate("page/all.ftl");
	}

	@Test
	public void testProcessMap() throws IOException, TemplateException {
		flagList.add("datatype");
		root.put("datatype", "datatype");
		root.put("String", "这是一个string字符串");
		root.put("Bytes", Byte.MAX_VALUE);
		root.put("Short", Short.MAX_VALUE);
		root.put("Integer", Integer.MAX_VALUE);
		root.put("Long", Long.MAX_VALUE);
		root.put("Float", Float.MAX_VALUE);
		root.put("Double", Double.MAX_VALUE);
		root.put("Boolean", false);
		root.put("Char", Character.MAX_VALUE);
		root.put("Date", new java.sql.Date(System.currentTimeMillis()));
		root.put("Null", null);
		
	}
	
	@Test
	public void testProcessList() throws TemplateException, IOException{
		flagList.add("list");
		root.put("listFlag", true);
		List<String> list = new ArrayList<String>();
		list.add("freeMarker1");
		list.add("freeMarker2");
		list.add("freeMarker3");
		root.put("list", list);
	}
	
	@Test
	public void testProcessMacro() throws TemplateException, IOException{
		flagList.add("CustomCommand");
		root.put("testMacro", "testMacro");
		root.put("user", "MyEclipse");
	}
	
	@Test
	public void testProcessNamespace() throws TemplateException, IOException{
		flagList.add("Namespace");
	}
	
	
	@After
	public void after() throws TemplateException, IOException{
		root.put("flagList", flagList);
		process(root);
	}
	
	
	
	private void process(Object obj) throws TemplateException, IOException{
		Writer out = new OutputStreamWriter(System.out);
		tmp.process(obj, out);
		out.flush();
	}
	

}
