package com.springboot.web;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.io.IOUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.model.Experience;
import com.springboot.model.Logement;
import com.springboot.model.Reclamation;
import com.springboot.model.Reservation;
import com.springboot.repository.ExperienceRepository;
import com.springboot.repository.LogementRepository;
import com.springboot.repository.ReclamationRepository;
import com.springboot.repository.ReservationRepository;

@Controller
public class MainController {
	@Autowired
	private LogementRepository logementRepository;

	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private ReclamationRepository reclamationRepository;
	
	  @Value("${x}") private String imageDir;
	 
	  @GetMapping("/shopMap")
		public String getShopMap(Model model) {
			model.addAttribute("contents", "shopMap :: shop_map");
			return "homeLayout";
		}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
		return "app";
	}
//////////////////////reclamation
@RequestMapping(value="/formR",method=RequestMethod.GET)
 	public String FormReclamation(Model model) {
	model.addAttribute("reclamation",new Reclamation());
	return "reclamation";
}

@RequestMapping(value="/saveR",method=RequestMethod.POST)
public String save(@Valid Reclamation reclamation,BindingResult bindingResult) {
if(bindingResult.hasErrors()) {
	return "reclamation"; }
reclamationRepository.save(reclamation);
return "reclamation"; }	 

@RequestMapping(value="/indexR")
public String indexR(Model model,
@RequestParam(name="page",defaultValue="0")int p,
@RequestParam(name="size",defaultValue="30")int s
) {

Page<Reclamation> pageReclamations=reclamationRepository.findAll(PageRequest.of(p, s));
model.addAttribute("listReclamations",pageReclamations.getContent());
int[] pages=new int[pageReclamations.getTotalPages()];
model.addAttribute("pages",pages);
model.addAttribute("size",s);
model.addAttribute("pageCourante",p);
return "rechercheR";
}

@RequestMapping(value="/supprimerR")
public String supprimerR(Long id) {
reclamationRepository.deleteById(id);
return "redirect:indexR";
}

	
	///test
	@GetMapping("/accueil")
	public String accueil() {
		return "accueil";
	}
	@RequestMapping(value="/test")
	public String test(Model model,
			@RequestParam(name="page",defaultValue="0")int p,
			@RequestParam(name="size",defaultValue="3")int s,
			@RequestParam(name="motCle",defaultValue="")String mc) {
		model.addAttribute("reservation", new Reservation());
		if (mc==null) {
			Page<Logement> pageLogements=logementRepository.findAll(PageRequest.of(p, s));
			model.addAttribute("listLogements",pageLogements.getContent());
			int[] pages=new int[pageLogements.getTotalPages()];
			model.addAttribute("pages",pages);
			model.addAttribute("size",s);
			model.addAttribute("pageCourante",p);
			return "affichageLog";
			}
		else {
			List<Logement> pageLogements=
					logementRepository.chercher("%"+mc+"%");
			model.addAttribute("listLogements",pageLogements);
					model.addAttribute("motCle",mc);
			return "index";
			
		}
		
	}
	@RequestMapping(value="/test/log",method=RequestMethod.GET)
	public String formtest(Model model) {
		model.addAttribute("reservation", new Reservation());
		return "log";
	}

	/*
	 * @GetMapping("/test") public String test(Model model) {
	 * 
	 * model.addAttribute("reservation", new Reservation()); return "index"; }
	 */
	///test
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String formLogement(Model model) {
		model.addAttribute("logement", new Logement());
		return "logement";
	}

				
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String savePic(Logement logement,@RequestParam(name="picture")MultipartFile file) throws Exception{
		if(!(file.isEmpty())) {
			logement.setImage(file.getOriginalFilename());
			logementRepository.save(logement);
			 file.transferTo(new File(imageDir+logement.getId())); 
						}
		
		return "confirmation";
	}

	
	
	  @RequestMapping(value="/getPhoto",produces=MediaType.IMAGE_JPEG_VALUE)
	  
	  @ResponseBody public byte[] getPhoto(Long id) throws Exception { 
		  File f=new File(imageDir+id);
		  return IOUtils.toByteArray(new FileInputStream(f)); }
	  
	
	@RequestMapping(value="/affichageLog")
	public String affichageLog(Model model,
			@RequestParam(name="page",defaultValue="0")int p,
			@RequestParam(name="size",defaultValue="3")int s,
			@RequestParam(name="motCle",defaultValue="")String mc) {
		if (mc==null) {
			Page<Logement> pageLogements=logementRepository.findAll(PageRequest.of(p, s));
			model.addAttribute("listLogements",pageLogements.getContent());
			int[] pages=new int[pageLogements.getTotalPages()];
			model.addAttribute("pages",pages);
			model.addAttribute("size",s);
			model.addAttribute("pageCourante",p);
			return "affichageLog";
			}
		else {
			List<Logement> pageLogements=
					logementRepository.chercher("%"+mc+"%");
			model.addAttribute("listLogements",pageLogements);
					model.addAttribute("motCle",mc);
			return "affichageLog";
			
		}
		
	}
	 @GetMapping("/edit")
	  public String edit(Model model ,Long id) {
		  Logement logement=logementRepository.findById(id).get();
		  model.addAttribute("logement",logement);
		  return "logementEditf"; 
	  }
	  

	  
	  
		@RequestMapping(value="/formReserv",method=RequestMethod.GET)
		public String formReservation(Model model,Long id) {
			Logement logement=logementRepository.findById(id).get();
			model.addAttribute("logement", new Logement());

			model.addAttribute("reservation", new Reservation());
			return "logementReserver";
		}
		
		@RequestMapping(value="/saveReserv",method=RequestMethod.POST)
		public String save(Model model,Reservation reservation) {
				
			reservationRepository.save(reservation);
			return "reservationConfirm";//confirmation
		}
		
		
		@RequestMapping(value="/AffichageReserv")
		public String Affichage(Model model,
				@RequestParam(name="page",defaultValue="0")int pa,
				@RequestParam(name="size",defaultValue="3")int si)
				{
				Page<Reservation> pageReservations=reservationRepository.findAll(PageRequest.of(pa, si));
				model.addAttribute("listReservs",pageReservations.getContent());
				int[] pages=new int[pageReservations.getTotalPages()];
				model.addAttribute("pages",pages);
				model.addAttribute("size",si);
				model.addAttribute("pageCourante",pa);
				return "AffichageReserv";
				}
	  
		 @GetMapping("/deleteReserv")
		  public String deleteReserv(Long id) {
			  reservationRepository.deleteById(id);
			  return "redirect:/AffichageReserv"; 
		  }
		  
		  @GetMapping("/editReserv")
		  public String editReserv(Model model ,Long id) {
			  Reservation reservation=reservationRepository.findById(id).get();
			  model.addAttribute("reservation",reservation);
			  return "reservationEdit"; 
		  }
		  @RequestMapping(value="/index1")
			public String index(Model model,
					@RequestParam(name="page",defaultValue="0")int p,
					@RequestParam(name="size",defaultValue="3")int s,
					@RequestParam(name="motCle",defaultValue="")String mc) {
				if (mc==null) {
					Page<Logement> pageLogements=logementRepository.findAll(PageRequest.of(p, s));
					model.addAttribute("listProduits",pageLogements.getContent());
					int[] pages=new int[pageLogements.getTotalPages()];
					model.addAttribute("pages",pages);
					model.addAttribute("size",s);
					model.addAttribute("pageCourante",p);
					return "recherche";
					}
				else {
					List<Logement> pageLogements=
							logementRepository.chercher("%"+mc+"%");
					model.addAttribute("listLogements",pageLogements);
					//int[] pages=new int[pageProduits.getTotalPages()];
					//model.addAttribute("pages",pages);
					//model.addAttribute("size",s);
					//model.addAttribute("pageCourante",p);
					model.addAttribute("motCle",mc);
					return "recherche";
					
				}
			
			}

		  
		  @GetMapping("/delete")
		  public String delete(Long id) {
			  logementRepository.deleteById(id);
			  return "redirect:/index1"; 
		  
	
}
		  
//////////////////////Experiences
		  @Autowired
		  ExperienceRepository experienceRepository ;
		  
@RequestMapping(value="/formExp",method=RequestMethod.GET)
public String FormExperience(Model model) {
model.addAttribute("experience",new Experience());
return "experience";
}

@RequestMapping(value="/saveExp")
public String save(Model model , @Valid Experience experience,BindingResult bindingResult) {
if(bindingResult.hasErrors()) {
 return "experience"; }


experienceRepository.save(experience);

return "redirect:indexExp"; }	 

@RequestMapping(value="/indexExp")
public String indexExp(Model model,
@RequestParam(name="page",defaultValue="0")int p,
@RequestParam(name="size",defaultValue="30")int s
) {

Page<Experience> pageExperiences=experienceRepository.findAll(PageRequest.of(p, s));
model.addAttribute("listExperiences",pageExperiences.getContent());
int[] pages=new int[pageExperiences.getTotalPages()];
model.addAttribute("pages",pages);
model.addAttribute("size",s);
model.addAttribute("pageCourante",p);
return "rechercheExp";
}

@RequestMapping(value="/supprimerExp")
public String supprimerExp(Long id) {
experienceRepository.deleteById(id);
return "redirect:indexExp";
}

@GetMapping("/modifierExp")
public String modifierExp(Model model ,Long id) {
	
//public String modifierExp(@Valid Experience experience,BindingResult bindingResult) {
//		if(bindingResult.hasErrors()) {
//		 return "experience"; }
//		experienceRepository.save(experience);
//		return "experience"; 
	
	Experience experience=experienceRepository.findById(id).get();
	
	//  Logement logement=logementRepository.findById(id).get();
	
	  model.addAttribute("experience",experience);
	  return "ExperienceEdit"; 
}
 

@RequestMapping(value="/supprimerttExp")
public String supprimerttExp() {
experienceRepository.deleteAll();;
return "redirect:indexExp";
}

}
