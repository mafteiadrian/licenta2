package com.maftei.licenta.web;

import com.maftei.licenta.domain.Interventie;
import com.maftei.licenta.service.AngajatService;
import com.maftei.licenta.service.ClientService;
import com.maftei.licenta.service.ConstatareService;
import com.maftei.licenta.service.EchipamentServiceService;
import com.maftei.licenta.service.InterventieService;
import java.util.ArrayList;
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

@RequestMapping("/interventies")
@Controller
public class InterventieController {

	@Autowired
    InterventieService interventieService;

	@Autowired
    AngajatService angajatService;

	@Autowired
    ClientService clientService;

	@Autowired
    ConstatareService constatareService;

	@Autowired
    EchipamentServiceService echipamentServiceService;

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid Interventie interventie, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, interventie);
            return "interventies/create";
        }
        uiModel.asMap().clear();
        interventieService.saveInterventie(interventie);
        return "redirect:/interventies/" + encodeUrlPathSegment(interventie.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new Interventie());
        List<String[]> dependencies = new ArrayList<String[]>();
        if (clientService.countAllClients() == 0) {
            dependencies.add(new String[] { "client", "clients" });
        }
        if (angajatService.countAllAngajats() == 0) {
            dependencies.add(new String[] { "angajat", "angajats" });
        }
        if (constatareService.countAllConstatares() == 0) {
            dependencies.add(new String[] { "constatare", "constatares" });
        }
        if (echipamentServiceService.countAllEchipamentServices() == 0) {
            dependencies.add(new String[] { "echipamentservice", "echipamentservices" });
        }
        uiModel.addAttribute("dependencies", dependencies);
        return "interventies/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("interventie", interventieService.findInterventie(id));
        uiModel.addAttribute("itemId", id);
        return "interventies/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("interventies", interventieService.findInterventieEntries(firstResult, sizeNo));
            float nrOfPages = (float) interventieService.countAllInterventies() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("interventies", interventieService.findAllInterventies());
        }
        addDateTimeFormatPatterns(uiModel);
        return "interventies/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid Interventie interventie, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, interventie);
            return "interventies/update";
        }
        uiModel.asMap().clear();
        interventieService.updateInterventie(interventie);
        return "redirect:/interventies/" + encodeUrlPathSegment(interventie.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, interventieService.findInterventie(id));
        return "interventies/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Interventie interventie = interventieService.findInterventie(id);
        interventieService.deleteInterventie(interventie);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/interventies";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
//        uiModel.addAttribute("interventie_datainceput_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
//        uiModel.addAttribute("interventie_datasfarsit_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, Interventie interventie) {
        uiModel.addAttribute("interventie", interventie);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("angajats", angajatService.findAllAngajats());
        uiModel.addAttribute("clients", clientService.findAllClients());
        uiModel.addAttribute("constatares", constatareService.findAllConstatares());
        uiModel.addAttribute("echipamentservices", echipamentServiceService.findAllEchipamentServices());
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
