/*
 * Copyright 2021 The Error Prone Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.errorprone.bugpatterns.javadoc;

import com.google.errorprone.CompilationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for {@link UnrecognisedCodeBlock}. */
@RunWith(JUnit4.class)
public final class UnrecognisedCodeBlockTest {
  private final CompilationTestHelper helper =
      CompilationTestHelper.newInstance(UnrecognisedCodeBlock.class, getClass());

  @Test
  public void positive() {
    helper
        .addSourceLines(
            "Test.java",
            "/**",
            " * // BUG: Diagnostic contains:",
            " * <pre>{@code",
            " *  foo() {",
            " * }</pre>",
            " */",
            "class Test {}")
        .doTest();
  }

  @Test
  public void negative() {
    helper
        .addSourceLines(
            "Test.java",
            "/**",
            " * <pre>{@code",
            " *  foo() {}",
            " * }</pre>",
            " */",
            "class Test {}")
        .doTest();
  }
}
