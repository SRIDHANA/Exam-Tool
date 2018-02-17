package com.sridhana.service.faculty;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.multipart.MultipartFile;

import com.sridhana.DAO.McqDAO;
import com.sridhana.model.Mcq;

public class UploadedFileService {

	private String tmpFolderPath = "C:\\Users\\Public\\Documents\\Examsite\\";
	
	private McqDAO mcqDAO;

	@Autowired
	@Qualifier(value = "mcqDAO")
	public void setMcqDAO(McqDAO mcqDAO) {
		this.mcqDAO = mcqDAO;
	}

	@Transactional
	public String processUploadedFile(MultipartFile uploadedFile) {
		if (uploadedFile == null) {
			return "";
		}
		
		File file = null;
		FileInputStream excelFile = null;
		Workbook workbook = null;
		Sheet datatypeSheet = null;
		Iterator<Row> iterator = null;
		FileOutputStream fos = null;

		Integer uploadedFileId = null;

		try {
			try {
				file = new File(tmpFolderPath + "/" + "TempFile_" + (new Date().getTime() * -1));
				file.createNewFile();
				fos = new FileOutputStream(file);
				fos.write(uploadedFile.getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (fos != null) {
					fos.close();
				}
			}

			uploadedFileId = (int) (new Date().getTime());
			excelFile = new FileInputStream(file);
			workbook = new XSSFWorkbook(excelFile);
			datatypeSheet = workbook.getSheetAt(0); 
			iterator = datatypeSheet.iterator(); 
			int count = 0;
			while (iterator.hasNext()) {
				Row currentRow = iterator.next();
				count++;
				if (count == 1) { //ignore row one 
					continue;
				}

				// Check and ignore blank rows
				if (StringUtils.isBlank(currentRow.getCell(0).getStringCellValue()) &&  
					StringUtils.isBlank(String.valueOf((int)currentRow.getCell(0).getNumericCellValue()))
						&&
					StringUtils.isBlank(currentRow.getCell(1).getStringCellValue()) &&  
					StringUtils.isBlank(String.valueOf((int)currentRow.getCell(1).getNumericCellValue()))
						&&
					StringUtils.isBlank(currentRow.getCell(2).getStringCellValue()) &&  
					StringUtils.isBlank(String.valueOf((int)currentRow.getCell(2).getNumericCellValue()))
				   ) {
					continue;
				}

				String questionCellValue = currentRow.getCell(0).getStringCellValue();
				String optionACellValue = currentRow.getCell(1).getStringCellValue();
				String optionBCellValue = currentRow.getCell(2).getStringCellValue();
				String optionCCellValue = currentRow.getCell(3).getStringCellValue();
				String optionDCellValue = currentRow.getCell(4).getStringCellValue();
				String optionECellValue = currentRow.getCell(5).getStringCellValue();
				String optionFCellValue = currentRow.getCell(6).getStringCellValue();
				String correctAnswerCellValue = currentRow.getCell(7).getStringCellValue();
				Integer marks_allotedCellValue = Integer.valueOf(String.valueOf((int)(currentRow.getCell(8).getNumericCellValue())));
				

				System.out.println( "questionCellValue: " + questionCellValue + ",  "
								+ "optionACellValue: " + optionACellValue + ",  "
								+ "optionBCellValue: " + optionBCellValue + ",  " 
								+ "optionCCellValue: " + optionCCellValue + ",  "
								+ "optionDCellValue: " + optionDCellValue + ",  " 
								+"correctAnswerCellValue: "	+ correctAnswerCellValue+ ",  " 
								+"marks_allotedCellValue" + marks_allotedCellValue);

				Mcq mcq = new Mcq();
				mcq.setQuestion(questionCellValue);
				mcq.setOptiona(optionACellValue);
				mcq.setOptionb(optionBCellValue);
				mcq.setOptionc(optionCCellValue);
				mcq.setOptiond(optionDCellValue);
				mcq.setOptione(optionECellValue);
				mcq.setOptionf(optionFCellValue);
				mcq.setAnswer(correctAnswerCellValue);
				mcqDAO.addMcq(mcq);

				System.out.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (workbook != null) {
					workbook.close();
					workbook = null;
				}
				if (excelFile != null) {
					excelFile.close();
					excelFile = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return (uploadedFileId != null ? String.valueOf(uploadedFileId) : "");
	}
    
	
}
