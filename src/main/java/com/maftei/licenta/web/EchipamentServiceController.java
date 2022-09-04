package com.maftei.licenta.web;

import com.maftei.licenta.domain.EchipamentService;
import com.maftei.licenta.service.EchipamentServiceService;

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

@RequestMapping("/echipamentservices")
@Controller
public class EchipamentServiceController {

	@Autowired
    EchipamentServiceService echipamentServiceService;

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid EchipamentService echipamentService, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, echipamentService);
            return "echipamentservices/create";
        }
        uiModel.asMap().clear();
        echipamentServiceService.saveEchipamentService(echipamentService);
        return "redirect:/echipamentservices/" + encodeUrlPathSegment(echipamentService.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new EchipamentService());
        return "echipamentservices/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("echipamentservice", echipamentServiceService.findEchipamentService(id));
        uiModel.addAttribute("itemId", id);
        return "echipamentservices/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("echipamentservices", echipamentServiceService.findEchipamentServiceEntries(firstResult, sizeNo));
            float nrOfPages = (float) echipamentServiceService.countAllEchipamentServices() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("echipamentservices", echipamentServiceService.findAllEchipamentServices());
        }
        return "echipamentservices/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid EchipamentService echipamentService, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, echipamentService);
            return "echipamentservices/update";
        }
        uiModel.asMap().clear();
        echipamentServiceService.updateEchipamentService(echipamentService);
        return "redirect:/echipamentservices/" + encodeUrlPathSegment(echipamentService.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, echipamentServiceService.findEchipamentService(id));
        return "echipamentservices/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        EchipamentService echipamentService = echipamentServiceService.findEchipamentService(id);
        echipamentServiceService.deleteEchipamentService(echipamentService);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/echipamentservices";
    }

	void populateEditForm(Model uiModel, EchipamentService echipamentService) {
        uiModel.addAttribute("echipamentService", echipamentService);
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
