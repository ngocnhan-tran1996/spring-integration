/*
 * Copyright 2015-present the original author or authors.
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

package org.springframework.integration.stomp;

import org.springframework.messaging.simp.stomp.StompSessionHandler;

/**
 * An abstraction to manage the STOMP Session and connection/disconnection
 * for {@link StompSessionHandler}.
 *
 * @author Artem Bilan
 * @since 4.2
 */
public interface StompSessionManager {

	void connect(StompSessionHandler handler);

	void disconnect(StompSessionHandler handler);

	boolean isAutoReceiptEnabled();

	boolean isConnected();

}
