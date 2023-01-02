package it.jdk.wiki.actions;

import it.jdk.wiki.context.RequestObject;
import it.jdk.wiki.context.ResponseAndView;
import it.jdk.wiki.controller.MyWikiException;

public interface Action {

	ResponseAndView createResponseAndView(RequestObject requestObject) throws MyWikiException;
}
