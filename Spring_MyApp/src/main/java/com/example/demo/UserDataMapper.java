//package com.example.demo;
//
//import java.util.Collection;
//
//import org.apache.ibatis.annotations.Mapper;
//
//@Mapper
//public interface UserDataMapper {
//
//    /**
//     * ���[�U�[�f�[�^�e�[�u��(user_data)��S���擾����
//     * @return ���[�U�[�f�[�^�e�[�u��(user_data)��S�f�[�^
//     */
//    Collection<ToDo> findAll();
//
//    /**
//     * �w�肵��ID�������[�U�[�f�[�^�e�[�u��(user_data)�̃f�[�^���擾����
//     * @param id ID
//     * @return ���[�U�[�f�[�^�e�[�u��(user_data)�̎w�肵��ID�̃f�[�^
//     */
//    ToDo findById(Long id);
//
//    /**
//     * �w�肵��ID�������[�U�[�f�[�^�e�[�u��(user_data)�̃f�[�^���폜����
//     * @param id ID
//     */
//    void deleteById(Long id);
//
//    /**
//     * �w�肵�����[�U�[�f�[�^�e�[�u��(user_data)�̃f�[�^��ǉ�����
//     * @param userData ���[�U�[�f�[�^�e�[�u��(user_data)�̒ǉ��f�[�^
//     */
//    void create(ToDo userData);
//
//    /**
//     * �w�肵�����[�U�[�f�[�^�e�[�u��(user_data)�̃f�[�^���X�V����
//     * @param userData ���[�U�[�f�[�^�e�[�u��(user_data)�̍X�V�f�[�^
//     */
//    void update(ToDo userData);
//
//    /**
//     * ���[�U�[�f�[�^�e�[�u��(user_data)�̍ő�lID���擾����
//     * @return ���[�U�[�f�[�^�e�[�u��(user_data)�̍ő�lID
//     */
//    long findMaxId();
//}