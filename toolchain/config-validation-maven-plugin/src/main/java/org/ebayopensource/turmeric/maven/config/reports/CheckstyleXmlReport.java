/*******************************************************************************
 * Copyright (c) 2006-2010 eBay Inc. All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *******************************************************************************/
package org.ebayopensource.turmeric.maven.config.reports;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.codehaus.plexus.util.IOUtil;
import org.ebayopensource.turmeric.maven.config.ConfigValidationMojo;
import org.ebayopensource.turmeric.maven.config.console.Console;

public class CheckstyleXmlReport extends AbstractReport {
    private FileWriter writer;
    private PrintWriter out;

    public CheckstyleXmlReport(Console console, File outputFile) throws IOException {
        super(console);
        this.writer = new FileWriter(outputFile);
        this.out = new PrintWriter(writer);
        this.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        this.out.printf("<checkstyle version=\"5.0\">%n");
    }

    @Override
    public void close() {
        super.close();
        out.println("</checkstyle>");
        IOUtil.close(out);
        IOUtil.close(writer);
    }

    public void fileStart(File file) {
        super.fileStart(file);
        out.printf("<file name=\"%s\">%n", XmlUtil.escaped(file));
    }

    public void fileEnd() {
        super.fileEnd();
        out.println("</file>");
    }

    @Override
    public void violation(String context, String format, Object... args) {
        out.printf("<error line=\"%d\"%n", 0);
        out.printf(" severity=\"error\"");
        out.printf(" message=\"%s: %s\"", XmlUtil.escaped(String.format(format, args)));
        out.printf(" source=\"%s\" />%n", XmlUtil.escaped(ConfigValidationMojo.class));
    }
}
