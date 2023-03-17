package com.inetbanking.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLutils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public CellStyle style;
	String path =null;

	public XLutils(String path){
		this.path=path;
	}
	



	public int getRowCount( String xlsheet) throws IOException {
		fi =new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int rowcount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;

	}


	public  int getCellCount( String xlsheet, int rownum) throws IOException {
		
			fi =new FileInputStream(path);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(xlsheet);
			row=ws.getRow(rownum);
			int cellcount = row.getLastCellNum();
			wb.close();
			fi.close();
			return cellcount;
		}
		
		
		public String getCellData( String xlsheet, int rownum, int colnum ) throws IOException {
			fi =new FileInputStream(path);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(xlsheet);
			row = ws.getRow(rownum);
			cell = row.getCell(colnum);
			
			DataFormatter formatter = new DataFormatter();
			String data;
			try {
			data = formatter.formatCellValue(cell);
			}catch(Exception e){
				data = "";
			}
			wb.close();
			fi.close();
			return data;
		}
		
		public void setCellData (String xlsheet, int rownum, int colnum, String data) throws IOException {
			fi =new FileInputStream(path);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(xlsheet);
			row = ws.getRow(rownum);
			cell = row.getCell(colnum);
			
			fo = new FileOutputStream(path);
			wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
			
			
		}
	

	}
	

