import client from './client';
export const getOffers = () => client.get('/offers');
export const getOffer = (id) => client.get(`/offers/${id}`);
