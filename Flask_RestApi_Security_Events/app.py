#!/usr/bin/env python

__author__ = "Rafael Hernandez"
__license__ = "MIT"
__version__ = "1.0.1"
__maintainer__ = "Rafael Hernandez"
__email__ = "hck3lool@gmail.com"
__status__ = "Done"

from datetime import datetime
from flask import Flask, render_template, request,redirect
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] ='sqlite:///security_events.db'
db = SQLAlchemy(app)


class Todo(db.Model):
    get_datetime = datetime.now()
    id = db.Column(db.Integer, primary_key = True)
    colaborador = db.Column(db.String(5), nullable = False)
    tipo_de_evento = db.Column(db.String(30), nullable = False)
    descripcion = db.Column(db.String(50), nullable = False)
    hora = db.Column(db.String(50), default = str(get_datetime.strftime("%H:%M:%S")))
    fecha = db.Column(db.String(50), default = str(get_datetime.date()))

    def __resp__(self):
        return '<Datos %r>' % self.id

@app.route('/', methods=['POST','GET'])
def index():
    if request.method == 'POST':
       colaborador_registrado = request.form['colaborador']
       evento_registrado = request.form['tipo_de_evento']
       descripcion_registrada = request.form['descripcion']
       nuevo_registro = Todo(colaborador = colaborador_registrado, tipo_de_evento = evento_registrado, descripcion = descripcion_registrada)
       try:
           db.session.add(nuevo_registro)
           db.session.commit()
           return redirect('/')
       except:
            return "Ocurrio un problema al agregar la tarea"
    else:
        datos = Todo.query.order_by(Todo.fecha).all()
        return render_template('index.html', datos = datos)

@app.route('/borrar/<int:id>')
def borrar(id):
    tarea_a_eliminar = Todo.query.get_or_404(id)

    try:
        db.session.delete(tarea_a_eliminar)
        db.session.commit()
        return redirect('/')
    except:
        return "Ocurrio un problema al eliminar los datos"

@app.route('/actualizar/<int:id>',methods=['POST','GET'])
def actualizar(id):
    task = Todo.query.get_or_404(id)

    if request.method == "POST":
        task.colaborador = request.form['colaborador']
        task.tipo_de_evento = request.form['tipo_de_evento']
        task.descripcion = request.form['descripcion']
        try:
            db.session.commit()
            return redirect("/")
        except:
            return "Ocurrio un problema al actualizar los datos"

    else:
        return render_template("update.html", task = task)

@app.route('/statistics',methods=['GET'])
def statistics():
    if request.method == "GET":
        try:
            event_statistics= db.session.query(Todo.id).count()

            event_type_statistics = db.session.query(Todo.tipo_de_evento).all()
            recopilacion_informacion = []
            denegacion_servicio = []
            acceso_denegado = []
            for element in range(len(event_type_statistics)):
                if event_type_statistics[element][0] == "Recopilacion de informacion":
                    recopilacion_informacion.append("1")
                elif event_type_statistics[element][0] == "Denegacion de servicio":
                    denegacion_servicio.append("2")
                elif event_type_statistics[element][0] == "Acceso no autorizado":
                    acceso_denegado.append("3")
                else:
                    print(event_statistics)

            time_statistics = db.session.query(Todo.tipo_de_evento, Todo.hora).all()
            date_statistics = db.session.query(Todo.tipo_de_evento, Todo.fecha).all()

            print("La cantidad de eventos registrados es: {}".format(event_statistics))
            print("La cantidad de registros del evento Recopilacion de informacion es: {}".format(recopilacion_informacion.count("1")))
            print("La cantidad de registros del evento Denegacion de servicio es: {}".format(denegacion_servicio.count("2")))
            print("La cantidad de registros del evento Acceso no autorizado es: {}".format(acceso_denegado.count("3")))

            return redirect("/")
        except:
            return "Ocurrio un problema al actualizar los datos"

    else:
        datos = Todo.query.order_by(Todo.fecha).all()
        return render_template('index.html', datos = datos)

if __name__ == "__main__":
    with app.app_context():
        db.create_all()
    app.run(debug=True)
