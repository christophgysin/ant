/*
 * Copyright  2005 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.apache.tools.ant.taskdefs.condition;

import org.apache.tools.ant.BuildFileTest;

/**
 * test for reachable things
 */
public class IsReachableTest extends BuildFileTest {

    public IsReachableTest(String name) {
        super(name);
    }

    public void setUp() {
        configureProject(
                "src/etc/testcases/taskdefs/conditions/isreachable.xml");
    }


    public void testLocalhost() throws Exception {
        executeTarget("testLocalhost");
    }

    public void testLocalhostURL() throws Exception {
        executeTarget("testLocalhostURL");
    }

    public void testIpv4localhost() throws Exception {
        executeTarget("testIpv4localhost");
    }

    public void testFTPURL() throws Exception {
        executeTarget("testFTPURL");
    }

    public void testBoth() throws Exception {
        expectBuildExceptionContaining("testBoth",
                "error on two targets",
                IsReachable.ERROR_BOTH_TARGETS);
    }

    public void testNoTargets() throws Exception {
        expectBuildExceptionContaining("testNoTargets",
                "no params",
                IsReachable.ERROR_NO_HOSTNAME);
    }

    public void testBadTimeout() throws Exception {
        expectBuildExceptionContaining("testBadTimeout",
                "error on -ve timeout",
                IsReachable.ERROR_BAD_TIMEOUT);
    }

    public void NotestFile() throws Exception {
        expectBuildExceptionContaining("testFile",
                "error on file URL",
                IsReachable.ERROR_NO_HOST_IN_URL);
    }

    public void testBadURL() throws Exception {
        expectBuildExceptionContaining("testBadURL",
                "error in URL",
                IsReachable.ERROR_BAD_URL);
    }
}