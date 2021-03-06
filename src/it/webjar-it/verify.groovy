/*
 *
 *   Copyright (c) 2016-2017 Red Hat, Inc.
 *
 *   Red Hat licenses this file to you under the Apache License, version
 *   2.0 (the "License"); you may not use this file except in compliance
 *   with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *   implied.  See the License for the specific language governing
 *   permissions and limitations under the License.
 */


import io.fabric8.vertx.maven.plugin.Verify

import java.util.jar.JarFile

String base = basedir
File primaryArtifactFile = new File(base, "target/vertx-demo-pkg-0.0.1.BUILD-SNAPSHOT.jar")
assert primaryArtifactFile.exists()
Verify.verifyVertxJar(primaryArtifactFile)

JarFile jar = new JarFile(primaryArtifactFile)
assert jar.getEntry("webroot") != null
assert jar.getEntry("webroot/vertx-web-client.js") != null
assert jar.getEntry("webroot/jquery/jquery.js") != null
