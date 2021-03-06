/*
 * Copyright (c) 2015 Andrew O'Malley
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.github.andrewoma.kwery.core

import org.apache.tomcat.jdbc.pool.DataSource
import kotlin.properties.Delegates

val hsqlDataSource: DataSource by Delegates.lazy {
    val dataSource = DataSource()
    dataSource.setDefaultAutoCommit(true)
    dataSource.setDriverClassName("org.hsqldb.jdbc.JDBCDriver")
    dataSource.setUrl("jdbc:hsqldb:mem:kwery")
    dataSource
}

val postgresDataSource: DataSource by Delegates.lazy {
    val dataSource = DataSource()
    dataSource.setDefaultAutoCommit(true)
    dataSource.setDriverClassName("org.postgresql.Driver")
    dataSource.setUrl("jdbc:postgresql://localhost:5432/kwery")
    dataSource.setJdbcInterceptors("com.github.andrewoma.kwery.tomcat.pool.StatementCache")
    dataSource
}
