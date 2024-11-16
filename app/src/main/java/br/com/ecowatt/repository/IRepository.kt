package br.com.ecowatt.repository

import java.io.IOException

/**
 * Generic repository interface for managing data operations.
 *
 * @param ID The type of the identifier for the model.
 * @param MODEL The type of the model.
 */
interface IRepository<ID, MODEL> {

    /**
     * Creates a new model in the remote database.
     *
     * @param model The model to be created.
     * @param onRequestFailure Callback function to handle request failure.
     * @param onRequestSuccess Callback function to handle request success with the created model ID.
     * @see MODEL
     */
    fun create(
        model: MODEL,
        onRequestFailure: (e: IOException) -> Unit,
        onRequestSuccess: (id: ID) -> Unit
    )

    /**
     * Fetches the list of models from the remote database.
     *
     * @param onRequestFailure Callback function to handle request failure.
     * @param onRequestSuccess Callback function to handle request success with the list of models.
     * @see MODEL
     */
    fun read(
        onRequestFailure: (e: IOException) -> Unit,
        onRequestSuccess: (hashMap: HashMap<ID, MODEL?>?) -> Unit
    )

    /**
     * Updates an existing model in the remote database.
     *
     * @param id The ID of the model to be updated.
     * @param model The model with updated data.
     * @param onRequestFailure Callback function to handle request failure.
     * @param onRequestSuccess Callback function to handle request success.
     * @see MODEL
     */
    fun update(
        id: ID,
        model: MODEL,
        onRequestFailure: (e: IOException) -> Unit,
        onRequestSuccess: () -> Unit
    )

    /**
     * Deletes a model from the remote database.
     *
     * @param id The ID of the model to be deleted.
     * @param onRequestFailure Callback function to handle request failure.
     * @param onRequestSuccess Callback function to handle request success.
     * @see MODEL
     */
    fun delete(
        id: ID,
        onRequestFailure: (e: IOException) -> Unit,
        onRequestSuccess: () -> Unit
    )
}