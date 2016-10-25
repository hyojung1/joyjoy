package com.bohyeon.web.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class ForTag extends TagSupport {
	int index = 0;

	@Override
	public int doStartTag() throws JspException {
		// �ٵ� ����
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doAfterBody() throws JspException {
		// ���뿡�� ������
		if (++index >= 5)
			return SKIP_BODY;
		// �ٵ� �ݺ�, �� ���·δ� ���ѹݺ�->ȭ�鿡�� ��������
		return EVAL_BODY_AGAIN;
	}

	@Override
	public int doEndTag() throws JspException {
		// ������ ���
		return EVAL_PAGE;
	}
	
	

}
