import axios from 'axios'

const api = axios.create({
    baseURL: 'http://localhost:3001/'
})

export const loadGenres = () => api.get('genres')
export const saveSeries = (newSeries) => api.post('series', newSeries)
export const updateSerie = (serie) => api.put('series/'+serie.id, serie)
export const loadSeriesByGenre = (genre) => api.get('series?genre='+genre)
export const deleteSeries = (id) => api.delete('series/'+id)
export const loadSeriesById = (id) => api.get('series/'+id)

const apis = {
    loadGenres,
    saveSeries,
    updateSerie,
    loadSeriesByGenre,
    deleteSeries,
    loadSeriesById
}

export default apis