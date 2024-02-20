import React from 'react';
import { Formik, Form, Field, ErrorMessage } from 'formik';
import * as Yup from 'yup';

const CityForm = ({ onSubmit }) => {
  const initialValues = {
    nome: '',
    estadoId: '',
  };

  const validationSchema = Yup.object({
    nome: Yup.string().required('Nome da cidade é obrigatório'),
    estadoId: Yup.string().required('Selecione um estado'),
  });

  return (
    <Formik initialValues={initialValues} validationSchema={validationSchema} onSubmit={onSubmit}>
      <Form>
        <Field type="text" name="nome" placeholder="Nome da Cidade" />
        <ErrorMessage name="nome" component="div" className="error" />
        <Field as="select" name="estadoId">
          <option value="">Selecione...</option>
          {/* Fill options with estados data dynamically */}
        </Field>
        <ErrorMessage name="estadoId" component="div" className="error" />
        <button type="submit">Salvar</button>
      </Form>
    </Formik>
  );
};

export default CityForm;