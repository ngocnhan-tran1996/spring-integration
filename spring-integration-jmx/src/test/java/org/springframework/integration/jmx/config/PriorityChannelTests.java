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

package org.springframework.integration.jmx.config;

import java.util.Set;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.channel.QueueChannelOperations;
import org.springframework.messaging.PollableChannel;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Dave Syer
 * @author Gary Russell
 * @since 2.0
 */
@SpringJUnitConfig
@DirtiesContext
public class PriorityChannelTests {

	@Autowired
	private MBeanServer server;

	@Autowired
	private PollableChannel testChannel;

	@Test
	public void testHandlerMBeanRegistration() throws Exception {
		Set<ObjectName> names = server.queryNames(new ObjectName("test.PriorityChannel:type=MessageHandler,*"), null);
		// Error handler plus the service activator
		assertThat(names.size()).isEqualTo(2);
	}

	@Test
	public void testChannelMBeanRegistration() throws Exception {
		Set<ObjectName> names = server.queryNames(new ObjectName("test.PriorityChannel:type=MessageChannel,name=testChannel,*"), null);
		assertThat(names.size()).isEqualTo(1);
		assertThat(server.getAttribute(names.iterator().next(), "QueueSize")).isEqualTo(0);
		assertThat(((QueueChannelOperations) testChannel).getQueueSize()).isEqualTo(0);
	}

	public static class Source {

		public String get() {
			return "foo";
		}

	}

}
