package com.example.tdd;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ConfirmReviewApprovalRepositoryImpl implements ConfirmReviewApprovalRepository{

    @Override
    public ConfirmReviewApprovalEntity findByNo(String no) {
        ConfirmReviewApprovalEntity confirmReviewApprovalEntity = new ConfirmReviewApprovalEntity();
        confirmReviewApprovalEntity.setNo(no);

        return confirmReviewApprovalEntity;
    }

    @Override
    public String test(String no) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends ConfirmReviewApprovalEntity> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends ConfirmReviewApprovalEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<ConfirmReviewApprovalEntity> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> strings) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ConfirmReviewApprovalEntity getOne(String s) {
        return null;
    }

    @Override
    public ConfirmReviewApprovalEntity getById(String s) {
        return null;
    }

    @Override
    public ConfirmReviewApprovalEntity getReferenceById(String s) {
        return null;
    }

    @Override
    public <S extends ConfirmReviewApprovalEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ConfirmReviewApprovalEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ConfirmReviewApprovalEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ConfirmReviewApprovalEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ConfirmReviewApprovalEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ConfirmReviewApprovalEntity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends ConfirmReviewApprovalEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends ConfirmReviewApprovalEntity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ConfirmReviewApprovalEntity> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ConfirmReviewApprovalEntity> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<ConfirmReviewApprovalEntity> findAll() {
        return null;
    }

    @Override
    public List<ConfirmReviewApprovalEntity> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(ConfirmReviewApprovalEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends ConfirmReviewApprovalEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<ConfirmReviewApprovalEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ConfirmReviewApprovalEntity> findAll(Pageable pageable) {
        return null;
    }
}
