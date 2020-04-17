package com.uca.capas.tarea.controller;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@RequestMapping("/data")
	public @ResponseBody String datos() {
		String datos = "Carlos Eduardo" + "<br>" + "Beltrán Ponce" + "<br>" + "00507511" + "<br>"
				+ "Ingeniería Informática" + "<br>" + "5 año";
		return datos;

	}

	@RequestMapping("/day")
	public @ResponseBody String day(HttpServletRequest request) {
		String weekday = " ";
		Integer year = Integer.parseInt(request.getParameter("year"));
		Integer month = Integer.parseInt(request.getParameter("month"));
		Integer day = Integer.parseInt(request.getParameter("day"));
		
		TimeZone timezone = TimeZone.getDefault();
		Calendar calendar = new GregorianCalendar(timezone);
		calendar.set(year, month - 1, day);

		int result = calendar.get(Calendar.DAY_OF_WEEK);

		switch (result) {
		case 1:
			weekday = "Domingo";
			break;
		case 2:
			weekday = "Lunes";
			break;
		case 3:
			weekday = "Martes";
			break;
		case 4:
			weekday = "Miercoles";
			break;
		case 5:
			weekday = "Jueves";
			break;
		case 6:
			weekday = "Viernes";
			break;
		case 7:
			weekday = "Sabado";
			break;
		}

		return weekday;

	}
}
