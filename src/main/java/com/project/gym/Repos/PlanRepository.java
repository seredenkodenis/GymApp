package com.project.gym.Repos;

import com.project.gym.Model.Plan;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PlanRepository implements JpaRepository<Plan, Long> {
    @Override
    public List<Plan> findAll() {
        return null;
    }

    @Override
    public List<Plan> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Plan> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Plan> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Plan plan) {

    }

    @Override
    public void deleteAll(Iterable<? extends Plan> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Plan> S save(S s) {
        return null;
    }

    @Override
    public <S extends Plan> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Plan> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Plan> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Plan> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Plan getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Plan> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Plan> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Plan> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Plan> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Plan> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Plan> boolean exists(Example<S> example) {
        return false;
    }
}
