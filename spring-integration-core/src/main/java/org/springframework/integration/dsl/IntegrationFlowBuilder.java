/*
 * Copyright 2016-present the original author or authors.
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

package org.springframework.integration.dsl;

import org.reactivestreams.Publisher;

import org.springframework.messaging.Message;

/**
 * @author Artem Bilan
 *
 * @since 5.0
 */
public final class IntegrationFlowBuilder extends IntegrationFlowDefinition<IntegrationFlowBuilder> {

	IntegrationFlowBuilder() {
	}

	@Override
	public StandardIntegrationFlow get() { // NOSONAR - not useless, increases visibility
		return super.get();
	}

	@Override
	public <T> Publisher<Message<T>> toReactivePublisher() { // NOSONAR - not useless, increases visibility
		return super.toReactivePublisher();
	}

	@Override
	public <T> Publisher<Message<T>> toReactivePublisher(boolean autoStartOnSubscribe) { // NOSONAR
		return super.toReactivePublisher(autoStartOnSubscribe);
	}

}
