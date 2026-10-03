import client from './client';
export const getStudents = () => client.get('/students');
export const getStudent = (id) => client.get(`/students/${id}`);
export const createStudent = (payload) => client.post('/students', payload);
export const updateStudent = (id, payload) => client.put(`/students/${id}`, payload);
export const deleteStudent = (id) => client.delete(`/students/${id}`);
