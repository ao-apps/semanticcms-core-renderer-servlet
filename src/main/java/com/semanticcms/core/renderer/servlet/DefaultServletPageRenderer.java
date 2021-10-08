/*
 * semanticcms-core-renderer-servlet - Support for SemanticCMS pages rendered in a Servlet environment.
 * Copyright (C) 2018, 2021  AO Industries, Inc.
 *     support@aoindustries.com
 *     7262 Bull Pen Cir
 *     Mobile, AL 36695
 *
 * This file is part of semanticcms-core-renderer-servlet.
 *
 * semanticcms-core-renderer-servlet is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * semanticcms-core-renderer-servlet is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with semanticcms-core-renderer-servlet.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.semanticcms.core.renderer.servlet;

import com.semanticcms.core.model.Page;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.SkipPageException;

public abstract class DefaultServletPageRenderer implements ServletPageRenderer {

	private final Page page;
	private final Map<String, ? extends Object> attributes;

	protected DefaultServletPageRenderer(Page page, Map<String, ? extends Object> attributes) {
		this.page = page;
		this.attributes = attributes;
	}

	@Override
	public void doRenderer(Writer out) throws IOException {
		try {
			HttpServletRequest request = (HttpServletRequest)attributes.get(REQUEST_RENDERER_ATTRIBUTE);
			if(request == null) throw new ServletException("Page attribute not found: " + REQUEST_RENDERER_ATTRIBUTE);
			HttpServletResponse response = (HttpServletResponse)attributes.get(RESPONSE_RENDERER_ATTRIBUTE);
			if(response == null) throw new ServletException("Page attribute not found: " + RESPONSE_RENDERER_ATTRIBUTE);
			doRenderer(page, request, response, out);
		} catch(ServletException e) {
			throw new IOException(e);
		} catch(SkipPageException e) {
			// Do nothing, this is a valid way for the renderer to complete
		}
	}

	@Override
	public abstract void doRenderer(
		Page page,
		HttpServletRequest request,
		HttpServletResponse response,
		Writer out
	) throws IOException, ServletException, SkipPageException;
}
