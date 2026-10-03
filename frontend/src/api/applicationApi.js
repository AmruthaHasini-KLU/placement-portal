import client from './client';
export const getApplications = (params) => client.get('/applications', { params });
export const getStudentApplications = (id) => client.get(`/applications/student/${id}`);
export const createApplication = (payload) => client.post('/applications', payload);
export const updateApplicationStatus = (id, payload) => client.patch(`/applications/${id}/status`, payload);
