/*Memento: Padrão que permite guardar e restaurar periodicamente o estado de um objeto sem revelar detalhes da sua implementação.
 *
 *       Utilizar quando: - queremos produzir snapshots dd estado de um objeto de forma a o restaurar
 * 
 *                        - acesso direto aos campos do objeto são uma violação direta do seu encapsulamento 
 * 
 *       Vantagens: - permite simplicar o código do objeto originador ao deixar um gestor (caretaker) tratar do seu histórico
 * 
 *                  - permite criar snapshots do seu estado sem violar o encapsulamento

 * 
 *       Desvantagens: - elevado consumo de memória caso sejam criados demasiados snapshots/mementos
 * 
 *                     - é necessária rastrear snapshots de forma a os destruir quando se tornam obsoletos
 */      
