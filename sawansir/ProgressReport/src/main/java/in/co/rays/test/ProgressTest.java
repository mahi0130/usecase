package in.co.rays.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import in.co.rays.dto.ProgressDTO;
import in.co.rays.model.ProgressModel;

public class ProgressTest {
	
	public static void main(String[] args) throws Exception {

		testAdd();
		//testSearch();
		 //testUpdate();
		// testDelete();
	
	}

	
	private static void testAdd() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ProgressDTO dto = new ProgressDTO();
		ProgressModel model = new ProgressModel();
		dto.setDeveloperName("mahi");
		dto.setWork("usecase");
		try {
			dto.setReportingDate(sdf.parse("2022-01-12"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dto.setTarget("project3");
		dto.setLastWeek("project4");
		dto.setCurrentWeek("project3");
		
		model.add(dto);
		
	}

}
