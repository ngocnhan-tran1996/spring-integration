/*
 * Copyright 2002-present the original author or authors.
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

package org.springframework.integration.ip.tcp.serializer;

import java.io.Serial;

/**
 * Used to communicate that a stream has closed, but between logical
 * messages.
 *
 * @author Gary Russell
 *
 * @since 2.0
 *
 */
public class SoftEndOfStreamException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = -2209857413498073058L;

	/**
	 * Default constructor.
	 */
	public SoftEndOfStreamException() {
	}

	/**
	 * Construct an instance with the message.
	 * @param message the message.
	 */
	public SoftEndOfStreamException(String message) {
		super(message);
	}

	/**
	 * Construct an instance with the message and cause.
	 * @param message the message.
	 * @param cause the cause.
	 * @since 4.3.21.
	 */
	public SoftEndOfStreamException(String message, Throwable cause) {
		super(message, cause);
	}

}
