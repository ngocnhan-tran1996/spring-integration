/*
 * Copyright 2020-present the original author or authors.
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

package org.springframework.integration.dsl

import org.springframework.integration.router.AbstractMessageRouter
import org.springframework.messaging.MessageChannel

/**
 * An  [AbstractRouterSpec] wrapped for Kotlin DSL.
 *
 * @property delegate the [AbstractRouterSpec] this instance is delegating to.
 *
 * @author Artem Bilan
 *
 * @since 5.3
 */
abstract class AbstractKotlinRouterSpec<S : AbstractRouterSpec<S, R>, R : AbstractMessageRouter>(override val delegate: S)
	: KotlinConsumerEndpointSpec<S, R>(delegate) {

	fun ignoreSendFailures(ignoreSendFailures: Boolean) {
		this.delegate.ignoreSendFailures(ignoreSendFailures)
	}

	fun applySequence(applySequence: Boolean) {
		this.delegate.applySequence(applySequence)
	}

	fun defaultOutputChannel(channelName: String) {
		this.delegate.defaultOutputChannel(channelName)
	}

	fun defaultOutputChannel(channel: MessageChannel) {
		this.delegate.defaultOutputChannel(channel)
	}

	fun defaultSubFlowMapping(subFlow: KotlinIntegrationFlowDefinition.() -> Unit) {
		defaultSubFlowMapping {definition -> subFlow(KotlinIntegrationFlowDefinition(definition)) }
	}

	fun defaultSubFlowMapping(subFlow: IntegrationFlow) {
		this.delegate.defaultSubFlowMapping(subFlow)
	}

	fun defaultOutputToParentFlow() {
		this.delegate.defaultOutputToParentFlow()
	}

}
