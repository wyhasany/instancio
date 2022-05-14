/*
 * Copyright 2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.instancio.test.features.generator.text;

import org.instancio.Instancio;
import org.instancio.junit.InstancioExtension;
import org.instancio.test.support.pojo.basic.StringHolder;
import org.instancio.test.support.tags.Feature;
import org.instancio.test.support.tags.FeatureTag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.instancio.Select.allStrings;

@FeatureTag({Feature.GENERATE, Feature.TEXT_PATTERN_GENERATOR})
@ExtendWith(InstancioExtension.class)
class TextPatternGeneratorTest {

    @Test
    void pattern() {
        final StringHolder result = Instancio.of(StringHolder.class)
                .generate(allStrings(), gen -> gen.text().pattern("Foo: #C#c#d."))
                .create();

        assertThat(result.getValue()).matches("^Foo: [A-Z][a-z][0-9].$");
    }
}