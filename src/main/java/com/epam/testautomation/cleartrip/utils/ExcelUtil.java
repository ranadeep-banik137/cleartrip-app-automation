package com.epam.testautomation.cleartrip.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.epam.testautomation.cleartrip.constant.Index;

@Component
public class ExcelUtil {
	
	private static final String DEFAULT_EXCEL_LOCATION = System.getProperty(Index.System.USER_DIR) + Index.Path.TEST_RESOURCES_PATH + Index.Folder.DATA_PROVIDER + Index.FlatFile.DEFAULT_EXCEL_FILE;
	private static final Logger LOGGER = Logger.getLogger(PropertyUtil.class.getName());
	Workbook workBook;
	Sheet sheet;
	
	private Workbook getXSSFWorkBook(final String path) {
		try {
			this.workBook = new XSSFWorkbook(path);
		} catch (IOException e) {
			LOGGER.warning(e.getCause().getMessage());
		}
		return this.workBook;
	}
	
	private Workbook getHSSFWorkBook(final String path) {
		FileInputStream input;
		try {
			input = new FileInputStream(new File(path));
			this.workBook =  new HSSFWorkbook(input);
		} catch (FileNotFoundException e) {
			LOGGER.warning(e.getCause().getMessage());
		} catch (IOException e) {
			LOGGER.warning(e.getCause().getMessage());
		}
		return this.workBook;
	}
	
	public ExcelUtil readDefaultExcel() {
		this.workBook = getXSSFWorkBook(DEFAULT_EXCEL_LOCATION);
		return this;
	}
	
	public ExcelUtil readExcel(final String path) {
		this.workBook = String.valueOf(path.charAt(path.length() - 1)).equals("x") ? getXSSFWorkBook(path) : getHSSFWorkBook(path);
		return this;
	}
	
	public String read(final String sheetName, final String columnName, final int rowNum) {
		this.sheet = this.workBook.getSheet(sheetName);
		return this.sheet.getRow(rowNum).getCell(getColumnNumberWithText(columnName)).getStringCellValue();
	}
	
	public int readInt(final String sheetName, final String columnName, final int rowNum) {
		this.sheet = this.workBook.getSheet(sheetName);
		Double d = this.sheet.getRow(rowNum).getCell(getColumnNumberWithText(columnName)).getNumericCellValue();
		return d.intValue();
	}
	
	public double readDouble(final String sheetName, final String columnName, final int rowNum) {
		this.sheet = this.workBook.getSheet(sheetName);
		return this.sheet.getRow(rowNum).getCell(getColumnNumberWithText(columnName)).getNumericCellValue();
	}
	
	private int getColumnNumberWithText(final String text) {
		int resultantColumn = 0;
		int lastColumnNum = this.sheet.getRow(0).getLastCellNum();
		for (int currentCell = 0; currentCell < lastColumnNum ; currentCell++) {
			if (this.sheet.getRow(0).getCell(currentCell).getStringCellValue().equals(text)) {
				resultantColumn = currentCell;
			}
		}
		return resultantColumn;
	}
}
