--
-- JBoss, Home of Professional Open Source
-- Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
-- contributors by the @authors tag. See the copyright.txt in the
-- distribution for a full listing of individual contributors.
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
-- http://www.apache.org/licenses/LICENSE-2.0
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
--

 
 -- load users
 insert into Users (id, name, surname) values (0, 'D', 'B') 
 
-- You can use this file to load seed data into the database using SQL statements
 insert into Events (id, time, message, user_id) values (0, '2001-10-11 17:00:00', 'event 1', 0) 
 insert into Events (id, time, message, user_id) values (1, '2001-10-11 19:00:00', 'event 2', 0) 
 

