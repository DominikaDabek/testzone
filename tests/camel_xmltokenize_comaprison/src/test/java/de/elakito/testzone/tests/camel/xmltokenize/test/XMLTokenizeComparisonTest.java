/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package de.elakito.testzone.tests.camel.xmltokenize.test;

import java.io.InputStream;
import java.util.Iterator;

import org.apache.camel.support.TokenXMLExpressionIterator;

public class XMLTokenizeComparisonTest extends AbstractXMLTokenizeComparisonTest {
    @Override
    protected TestInstance createTokenIterator(String type, char mode) {
        TestInstance ti = null;
        if ("rss".equals(type)) {
            if (mode == 'i') {
                ti = new TestTokenIterator("<item>", "<rss>");
            } else if (mode == 'w') {
                ti = new TestTokenIterator("<item>", "<*>");
            }
        } else if ("parts".equals(type)) {
            if (mode == 'i') {
                ti = new TestTokenIterator("<Part>", "<PartMessage>");
            } else if (mode == 'w') {
                ti = new TestTokenIterator("<Part>", "<*>");
            }
        }
            
        return ti;
    }

    @Override
    protected String getTokenizerName() {
        return "xmlTokenize";
    }

    // the regex based xml tokenzier of camel 2.13.2 that uses a complex regex that works for the normal start
    // end elements as well as self-closed elements
    private static class TestTokenIterator extends TokenXMLExpressionIterator implements TestInstance {

        public TestTokenIterator(String tagToken, String inheritNamespaceToken) {
            super(tagToken, inheritNamespaceToken);
        }

        @Override
        public Iterator<?> createIterator(InputStream in, String charset) {
            return super.createIterator(in, charset);
        }
    }
}
