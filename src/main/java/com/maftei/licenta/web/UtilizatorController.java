package com.maftei.licenta.web;

import com.maftei.licenta.domain.Utilizator;
import com.maftei.licenta.service.AngajatService;
import com.maftei.licenta.service.RolService;
import com.maftei.licenta.service.UtilizatorService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

@RequestMapping("/utilizators")
@Controller
public class UtilizatorController {

	@Autowired
    UtilizatorService utilizatorService;

	@Autowired
    AngajatService angajatService;

	@Autowired
    RolService rolService;

    @Autowired
    PasswordEncoder passwordEncoder;

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid Utilizator utilizator, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, utilizator);
            return "utilizators/create";
        }
        uiModel.asMap().clear();
        utilizator.setParola(passwordEncoder.encode(utilizator.getParola()));
        utilizatorService.saveUtilizator(utilizator);
        return "redirect:/utilizators/" + encodeUrlPathSegment(utilizator.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new Utilizator());
        return "utilizators/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("utilizator", utilizatorService.findUtilizator(id));
        uiModel.addAttribute("itemId", id);
        return "utilizators/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("utilizators", utilizatorService.findUtilizatorEntries(firstResult, sizeNo));
            float nrOfPages = (float) utilizatorService.countAllUtilizators() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("utilizators", utilizatorService.findAllUtilizators());
        }
        return "utilizators/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid Utilizator utilizator, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, utilizator);
            return "utilizators/update";
        }
        uiModel.asMap().clear();
        utilizatorService.updateUtilizator(utilizator);
        return "redirect:/utilizators/" + encodeUrlPathSegment(utilizator.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, utilizatorService.findUtilizator(id));
        return "utilizators/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Utilizator utilizator = utilizatorService.findUtilizator(id);
        utilizatorService.deleteUtilizator(utilizator);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/utilizators";
    }

	void populateEditForm(Model uiModel, Utilizator utilizator) {
        uiModel.addAttribute("utilizator", utilizator);
        uiModel.addAttribute("angajats", angajatService.findAllAngajats());
        uiModel.addAttribute("rols", rolService.findAllRols());
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
