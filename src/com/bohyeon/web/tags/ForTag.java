package com.bohyeon.web.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class ForTag extends TagSupport {
	int index = 0;

	@Override
	public int doStartTag() throws JspException {
		// 바디 포함
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doAfterBody() throws JspException {
		// 이쯤에서 빠지자
		if (++index >= 5)
			return SKIP_BODY;
		// 바디 반복, 이 상태로는 무한반복->화면에서 받지못해
		return EVAL_BODY_AGAIN;
	}

	@Override
	public int doEndTag() throws JspException {
		// 나머지 출력
		return EVAL_PAGE;
	}
	
	

}
