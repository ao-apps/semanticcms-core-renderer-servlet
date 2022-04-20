/*
 * semanticcms-core-renderer-servlet - Support for SemanticCMS pages rendered in a Servlet environment.
 * Copyright (C) 2018, 2022  AO Industries, Inc.
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
 * along with semanticcms-core-renderer-servlet.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.semanticcms.core.renderer.servlet;

import com.semanticcms.core.model.Page;
import com.semanticcms.core.renderer.PageRenderer;
import java.io.IOException;
import java.io.Writer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.SkipPageException;

public interface ServletPageRenderer extends PageRenderer {

  String REQUEST_RENDERER_ATTRIBUTE = ServletPageRenderer.class.getName() + ".request";
  String RESPONSE_RENDERER_ATTRIBUTE = ServletPageRenderer.class.getName() + ".response";

  // Java 1.8: default methods instead of separate DefaultServletRenderer class
  void doRenderer(
    Page page,
    HttpServletRequest request,
    HttpServletResponse response,
    Writer out
  ) throws IOException, ServletException, SkipPageException;
}
