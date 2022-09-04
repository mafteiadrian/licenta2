package com.maftei.licenta.web;

import com.maftei.licenta.domain.EchipamentProductie;
import com.maftei.licenta.domain.Operatiune;
import com.maftei.licenta.domain.StatusEchipament;
import com.maftei.licenta.service.EchipamentProductieService;
import com.maftei.licenta.service.MaterialService;

import java.util.Arrays;
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

@RequestMapping("/echipamentproducties")
@Controller
public class EchipamentProductieController {

	@Autowired
    EchipamentProductieService echipamentProductieService;

	@Autowired
    MaterialService materialService;

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid EchipamentProductie echipamentProductie, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, echipamentProductie);
            return "echipamentproducties/create";
        }
        uiModel.asMap().clear();
        echipamentProductieService.saveEchipamentProductie(echipamentProductie);
        return "redirect:/echipamentproducties/" + encodeUrlPathSegment(echipamentProductie.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new EchipamentProductie());
        return "echipamentproducties/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("echipamentproductie", echipamentProductieService.findEchipamentProductie(id));
        uiModel.addAttribute("itemId", id);
        return "echipamentproducties/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("echipamentproducties", echipamentProductieService.findEchipamentProductieEntries(firstResult, sizeNo));
            float nrOfPages = (float) echipamentProductieService.countAllEchipamentProducties() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("echipamentproducties", echipamentProductieService.findAllEchipamentProducties());
        }
        return "echipamentproducties/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid EchipamentProductie echipamentProductie, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, echipamentProductie);
            return "echipamentproducties/update";
        }
        uiModel.asMap().clear();
        echipamentProductieService.updateEchipamentProductie(echipamentProductie);
        return "redirect:/echipamentproducties/" + encodeUrlPathSegment(echipamentProductie.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, echipamentProductieService.findEchipamentProductie(id));
        return "echipamentproducties/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        EchipamentProductie echipamentProductie = echipamentProductieService.findEchipamentProductie(id);
        echipamentProductieService.deleteEchipamentProductie(echipamentProductie);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/echipamentproducties";
    }

	void populateEditForm(Model uiModel, EchipamentProductie echipamentProductie) {
        uiModel.addAttribute("echipamentProductie", echipamentProductie);
        uiModel.addAttribute("materials", materialService.findAllMaterials());
        uiModel.addAttribute("operatiunes", Arrays.asList(Operatiune.values()));
        uiModel.addAttribute("statusechipaments", Arrays.asList(StatusEchipament.values()));
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
