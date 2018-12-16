package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.ForSemeter;
import kr.ac.hansung.model.Offer;
import kr.ac.hansung.service.OfferService;

@Controller
public class OfferController {

	@Autowired
	private OfferService offerService;

	@RequestMapping("/offers")
	public String showOffers(Model model) {
		List<Offer> offers = offerService.getCurrentAll();

		ForSemeter fourone = new ForSemeter(), fourtwo = new ForSemeter(), fiveone = new ForSemeter(),
				seventwo = new ForSemeter(),  eightone= new ForSemeter();
		fourone.setYear(2014);
		fourone.setSemester(1);
		fourone.setTotalGrade(0);
		fourtwo.setYear(2014);
		fourtwo.setSemester(2);
		fourtwo.setTotalGrade(0);
		fiveone.setYear(2015);
		fiveone.setSemester(1);
		fiveone.setTotalGrade(0);
		seventwo.setYear(2017);
		seventwo.setSemester(2);
		seventwo.setTotalGrade(0);
		eightone.setYear(2018);
		eightone.setSemester(1);
		eightone.setTotalGrade(0);

		for (Offer o : offers) {
			if (o.getYear() == 2014 && o.getSemester() == 1) {
				fourone.setTotalGrade(fourone.getTotalGrade() + o.getGrade());
			}
			if (o.getYear() == 2014 && o.getSemester() == 2) {
				fourtwo.setTotalGrade(fourtwo.getTotalGrade() + o.getGrade());
			}
			if (o.getYear() == 2015 && o.getSemester() == 1) {
				fiveone.setTotalGrade(fiveone.getTotalGrade() + o.getGrade());
			}
			if (o.getYear() == 2017 && o.getSemester() == 2) {
				seventwo.setTotalGrade(seventwo.getTotalGrade() + o.getGrade());
			}
			if (o.getYear() == 2018 && o.getSemester() == 1) {
				eightone.setTotalGrade(eightone.getTotalGrade() + o.getGrade());
			}
		}

		model.addAttribute("fourone", fourone);
		model.addAttribute("fourtwo", fourtwo);
		model.addAttribute("fiveone", fiveone);
		model.addAttribute("seventwo", seventwo);
		model.addAttribute("eightone", eightone);

		return "offers";
	}

	@RequestMapping("/semester")
	public String showSemester(@RequestParam("year") String year, @RequestParam("semester") String semester,
			Model model) {

		int yearInt = Integer.parseInt(year);
		int semesterInt = Integer.parseInt(semester);

		List<Offer> offers = offerService.getCurrent(yearInt, semesterInt);

		model.addAttribute("offers", offers);

		return "semester";
	}

	@RequestMapping("/createoffer")
	public String createOffers(Model model) {

		model.addAttribute("offer", new Offer());

		return "createoffer";
	}

	@RequestMapping(value = "/docreate", produces = "text/html; charset=utf-8")
	public String docreate(Model model, @Valid Offer offer, BindingResult result) {

		System.out.println(offer.getClassname());

		if (result.hasErrors()) {
			System.out.println("===Form data dose not validated");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}

			return "createoffer";
		}

		offerService.insert(offer);

		return "offercreated";
	}
}
