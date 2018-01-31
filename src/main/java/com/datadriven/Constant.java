package com.datadriven;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Constant {

	public static final String URL = "http://www.store.demoqa.com";

	public static final String Username = "testuser_1";

	public static final String Password = "Test@123";

	public static Path currentRelativePath = Paths.get("");

	public static final String Path_TestData = currentRelativePath.toAbsolutePath().toString() + File.separator
			+ "TestData" + File.separator;

	public static final String File_TestData = "testdata.xlsx";

}
