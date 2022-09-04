package com.maftei.licenta.web;

import com.maftei.licenta.domain.Job;
import com.maftei.licenta.domain.StatusComanda;
import com.maftei.licenta.domain.TipFinisare;
import com.maftei.licenta.service.AngajatService;
import com.maftei.licenta.service.ClientService;
import com.maftei.licenta.service.EchipamentProductieService;
import com.maftei.licenta.service.JobService;
import com.maftei.licenta.service.MaterialService;
import com.maftei.licenta.service.NotEnoughMaterialInStockException;
import com.maftei.licenta.service.UtilizatorService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

@RequestMapping("/jobs")
@Controller
public class JobController {

	@Autowired
    JobService jobService;

	@Autowired
    AngajatService angajatService;
	
	@Autowired
	UtilizatorService utilizatorService;

	@Autowired
    ClientService clientService;

	@Autowired
    EchipamentProductieService echipamentProductieService;

	@Autowired
    MaterialService materialService;

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid Job job, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, job);
            return "jobs/create";
        }
        uiModel.asMap().clear();
        try {
			jobService.saveJob(job);
			return "redirect:/jobs/" + encodeUrlPathSegment(job.getId().toString(), httpServletRequest);
		} catch (NotEnoughMaterialInStockException e) {
			uiModel.addAttribute("emptyStock", true);
			populateEditForm(uiModel, job);
            return "jobs/create";
		}
       
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new Job());
        List<String[]> dependencies = new ArrayList<String[]>();
        if (clientService.countAllClients() == 0) {
            dependencies.add(new String[] { "client", "clients" });
        }
        if (materialService.countAllMaterials() == 0) {
            dependencies.add(new String[] { "material", "materials" });
        }
        if (angajatService.countAllAngajats() == 0) {
            dependencies.add(new String[] { "angajat", "angajats" });
        }
        if (echipamentProductieService.countAllEchipamentProducties() == 0) {
            dependencies.add(new String[] { "echipamentproductie", "echipamentproducties" });
        }
        uiModel.addAttribute("dependencies", dependencies);
        return "jobs/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("job", jobService.findJob(id));
        uiModel.addAttribute("itemId", id);
        return "jobs/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("jobs", jobService.findJobEntries(firstResult, sizeNo));
            float nrOfPages = (float) jobService.countAllJobs() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("jobs", jobService.findAllJobs());
        }
        addDateTimeFormatPatterns(uiModel);
        return "jobs/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid Job job, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, job);
            return "jobs/update";
        }
        uiModel.asMap().clear();
        Job oldJob = jobService.findJob(job.getId());
        try {
			jobService.updateJob(job, oldJob.getDimensiuni().getLatime() * oldJob.getDimensiuni().getLungime());
		}  catch (NotEnoughMaterialInStockException e) {
			uiModel.addAttribute("emptyStock", true);
			populateEditForm(uiModel, job);
            return "jobs/update";
		}
        return "redirect:/jobs/" + encodeUrlPathSegment(job.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel, HttpServletRequest httpServletRequest) {
		if(checkPermission(id, httpServletRequest)){
			populateEditForm(uiModel, jobService.findJob(id));
	        return "jobs/update";
		} else {
			return "redirect:/jobs";
		}
        
    }

	private boolean checkPermission(Long id, HttpServletRequest httpServletRequest) {
		return httpServletRequest.isUserInRole("ROLE_admin") || utilizatorService.findByUsername(httpServletRequest.getRemoteUser()).getAngajat().getId() == jobService.findJob(id).getResponsabil().getId();
		
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel, HttpServletRequest httpServletRequest) {
        if(checkPermission(id, httpServletRequest)){
        	Job job = jobService.findJob(id);
            jobService.deleteJob(job);
        }
		
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/jobs";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
//        uiModel.addAttribute("job_dataprimirii_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
//        uiModel.addAttribute("job_datafinalizarii_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, Job job) {
        uiModel.addAttribute("job", job);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("angajats", angajatService.findAllAngajats());
        uiModel.addAttribute("clients", clientService.findAllClients());
        uiModel.addAttribute("echipamentproducties", echipamentProductieService.findAllEchipamentProducties());
        uiModel.addAttribute("materials", materialService.findAllMaterials());
        uiModel.addAttribute("statuscomandas", Arrays.asList(StatusComanda.values()));
        uiModel.addAttribute("tipfinisares", Arrays.asList(TipFinisare.values()));
        
    }

	String encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        return pathSegment;
    }
}
