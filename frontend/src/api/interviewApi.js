import client from './client';
export const getInterviews = () => client.get('/interviews');
export const getInterview = (id) => client.get(`/interviews/${id}`);
