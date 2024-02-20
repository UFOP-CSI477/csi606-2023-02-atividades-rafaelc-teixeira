import React, { useState } from 'react';
import { Formik, Form, Field, ErrorMessage } from 'formik';
import * as Yup from 'yup';
import axios from 'axios';

const BloodTypeForm = () => {
  const initialValues = {
    tipo: '',
    fator: '',
  };

  const validationSchema = Yup.object({
    tipo: Yup.string().required('Tipo sanguíneo é obrigatório'),
    fator: Yup.string().required('Fator Rh é obrigatório'),
  });

  const onSubmit = async (values, actions) => {
    try {
      const response = await axios.post('http://localhost:8080/tipos-sanguineos', values);
      actions.resetForm();
    } catch (error) {
    }
  };

  return (
    <Formik initialValues={initialValues} validationSchema={validationSchema} onSubmit={onSubmit}>
      <Form>
        <Field type="text" name="tipo" placeholder="Tipo sanguíneo (ex: A+)" />
        <ErrorMessage name="tipo" component="div" className="error" />
        <Field type="text" name="fator" placeholder="Fator Rh (ex: +)" />
        <ErrorMessage name="fator" component="div" className="error" />
        <button type="submit">Salvar</button>
      </Form>
    </Formik>
  );
};

export default BloodTypeForm;