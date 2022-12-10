/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.accumulo.server.data;

import org.apache.accumulo.core.data.ColumnUpdate;

public class ServerColumnUpdate extends ColumnUpdate {

  ServerMutation parent;

  public ServerColumnUpdate(byte[] cf, byte[] cq, byte[] cv, boolean hasts, long ts,
      boolean deleted, byte[] val, ServerMutation serverMutation) {
    super(cf, cq, cv, hasts, ts, deleted, val);
    parent = serverMutation;
  }

  @Override
  public long getTimestamp() {
    if (hasTimestamp()) {
      return super.getTimestamp();
    }
    return parent.getSystemTimestamp();
  }

}
