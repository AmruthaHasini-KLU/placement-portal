import client from './client';
export const getJobs = () => client.get('/jobs');
export const getJob = (id) => client.get(`/jobs/${id}`);
export const createJob = (payload) => client.post('/jobs', payload);
