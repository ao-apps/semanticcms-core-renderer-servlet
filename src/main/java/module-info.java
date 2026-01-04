/*
 * semanticcms-core-renderer-servlet - Support for SemanticCMS pages rendered in a Servlet environment.
 * Copyright (C) 2021, 2022, 2025, 2026  AO Industries, Inc.
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
module com.semanticcms.core.renderer.servlet {
  exports com.semanticcms.core.renderer.servlet;
  // Direct
  requires jakarta.servlet; // <groupId>jakarta.servlet</groupId><artifactId>jakarta.servlet-api</artifactId>
  requires jakarta.servlet.jsp; // <groupId>jakarta.servlet.jsp</groupId><artifactId>jakarta.servlet.jsp-api</artifactId>
  requires com.semanticcms.core.model; // <groupId>com.semanticcms</groupId><artifactId>semanticcms-core-model</artifactId>
  requires com.semanticcms.core.renderer; // <groupId>com.semanticcms</groupId><artifactId>semanticcms-core-renderer</artifactId>
  // Direct (requires transitive)
  requires static jakarta.el; // <groupId>jakarta.el</groupId><artifactId>jakarta.el-api</artifactId>
}
