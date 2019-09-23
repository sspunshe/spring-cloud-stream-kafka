package com.cloud.stream.springcloudstreamkafka.repository;

import com.cloud.stream.springcloudstreamkafka.model.Person;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@ViewIndexed(designDoc = "spring-integration")
public interface PersonRepository extends CrudRepository<Person, UUID> {
}
