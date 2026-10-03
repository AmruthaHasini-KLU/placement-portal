import client from './client';
export const getCompanies = () => client.get('/companies');
export const getCompany = (id) => client.get(`/companies/${id}`);
