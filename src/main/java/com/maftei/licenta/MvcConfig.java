package com.maftei.licenta;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.ui.context.support.ResourceBundleThemeSource;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.theme.CookieThemeResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
public class MvcConfig {

    @Bean
    public UrlBasedViewResolver tilesViewResolver() {
        TilesViewResolver tilesViewResolver = new TilesViewResolver();
        return tilesViewResolver;
    }

    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();

        String[] defs = { "/WEB-INF/layouts/layouts.xml", "/WEB-INF/views/**/views.xml" };
        tilesConfigurer.setDefinitions(defs);

        return tilesConfigurer;
    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource localiztionResource = new ReloadableResourceBundleMessageSource();
        localiztionResource.setBasenames("WEB-INF/i18n/messages","WEB-INF/i18n/application");
        localiztionResource.setFallbackToSystemLocale(false);
        return localiztionResource;
    }

    @Bean
    public CookieLocaleResolver localeResolver(){
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setCookieName("locale");
        return localeResolver;
    }

    @Bean
    public ResourceBundleThemeSource themeSource() {
        return new ResourceBundleThemeSource();
    }

    @Bean
    public CookieThemeResolver themeResolver() {
        CookieThemeResolver cookieLocaleResolver = new CookieThemeResolver();
        cookieLocaleResolver.setCookieName("theme");
        return cookieLocaleResolver;
    }
}